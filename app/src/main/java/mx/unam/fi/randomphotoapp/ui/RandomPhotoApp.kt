package mx.unam.fi.randomphotoapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mx.unam.fi.randomphotoapp.R
import mx.unam.fi.randomphotoapp.ui.screens.HomeScreen
import mx.unam.fi.randomphotoapp.viewmmodel.RandomImgViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RImgApp(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = { AppTopBar(scrollBehavior = scrollBehavior)}
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()) {
            val randomImgViewModel:RandomImgViewModel = viewModel()
            HomeScreen(imgUiState = randomImgViewModel.imgUiState, contentPadding = it)

        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF018786)
        ),
        actions = {
            Image(
                painter = painterResource(id = R.drawable.link),
                contentDescription = "Succesfull",
                modifier = Modifier.size(30.dp)
            )
        },
    )

}