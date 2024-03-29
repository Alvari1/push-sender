import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken("put_token_here")
        .build()

    FirebaseMessaging.getInstance().send(message)

    val message2 = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology",
          "postContent": "some post content here"
        }""".trimIndent())
        .setToken("put_token_here")
        .build()

    FirebaseMessaging.getInstance().send(message2)

    val message3 = Message.builder()
        .putData("action", "STRANGER")
        .putData("content", """{
          "userId": 1,
          "postId": 2,
          "postContent": "some post content here"
        }""".trimIndent())
        .setToken("put_token_here")
        .build()

    FirebaseMessaging.getInstance().send(message3)
}
