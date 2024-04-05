package au.com.softclient.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import au.com.softclient.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android");
                    //CreateUI();
                    ConstraintView();

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Preview
@Composable
fun CreateUI(){
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)){
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()) {
            repeat(50){ Text(text = "Hello Jaffna", fontSize = 20.sp)}
            Text(text = "Hello World!", fontSize = 16.sp)
        }

    }
}

@Preview
@Composable
fun ConstraintView(){
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(Color.Yellow)) {

        val(one, two, three, four) = createRefs();

        Button(onClick = { /*TODO*/ }, Modifier.constrainAs(one){
            top.linkTo(parent.top, 18.dp)
            bottom.linkTo(parent.bottom, 18.dp)
            start.linkTo(parent.start, 18.dp)
            end.linkTo(parent.end, 18.dp)
        }) {
            Text(text = "One Button");
        }
        Button(onClick = { /*TODO*/ }, Modifier.constrainAs(two){
            top.linkTo(one.bottom, 18.dp)
            start.linkTo(one.start, 18.dp)
            end.linkTo(one.end)
        }) {
            Text(text = "Two Button");
        }
        Button(onClick = { /*TODO*/ }, Modifier.constrainAs(three){
            top.linkTo(two.bottom, 18.dp)
            start.linkTo(two.start, 18.dp)
            end.linkTo(two.end)
        }) {
            Text(text = "Three Button");
        }
        Button(onClick = { /*TODO*/ }, Modifier.constrainAs(four){
            top.linkTo(three.bottom, 18.dp)
            start.linkTo(three.start)
            end.linkTo(three.end)
        }) {
            Text(text = "Four Button");
        }

    }

}