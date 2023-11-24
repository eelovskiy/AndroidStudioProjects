package com.example.taskmanagercompletedtasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagercompletedtasks.ui.theme.TaskManagerCompletedTasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerCompletedTasksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskCompletionText(
                        completionText = "All tasks completed",
                        goodJobText = "Nice work!"
                    )
                }
            }
        }
    }
}

@Composable
fun TaskCompletionText(completionText: String, goodJobText: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            )
        Text(
            text = completionText,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(top = 24.dp, bottom = 8.dp)

        )
        Text(
            text = goodJobText,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = modifier
        )
    }
}

@Composable
fun TaskCompletionImage(completionText: String, goodJobText: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Box{
        Image(
            painter = image,
            contentDescription = null,

        )
       TaskCompletionText(completionText = completionText, goodJobText = goodJobText)

    }
}

@Preview(showBackground = true)
@Composable
fun TaskCompletionWindowPreview() {
    TaskManagerCompletedTasksTheme {
        TaskCompletionText(
            completionText = stringResource(R.string.all_tasks_completed),
            goodJobText = stringResource(R.string.good_job)
        )
    }
}