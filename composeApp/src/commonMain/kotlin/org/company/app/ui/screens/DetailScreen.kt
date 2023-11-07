package org.company.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.company.app.theme.LocalThemeIsDark

@Composable
fun DetailScreen() {

    Column(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)) {

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Wallpaper KMP",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.weight(1.0f))

            var isDark by LocalThemeIsDark.current
            IconButton(
                onClick = { isDark = !isDark }
            ) {
                Icon(
                    modifier = Modifier.padding(8.dp).size(20.dp),
                    imageVector = if (isDark) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = null
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ), // Add padding for spacing
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                // AsyncImage with rounded corners
//                        AsyncImage(
//                            model = image ?: "",
//                            contentDescription = "",
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .aspectRatio(1f)
//                                .clip(RoundedCornerShape(8.dp)), // Rounded corners
//                            contentScale = ContentScale.Crop
//                        )
                IconButton(
                    onClick = {

                    },
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {

                }
                IconButton(
                    onClick = {

                    },
                    modifier = Modifier.align(Alignment.BottomStart)
                ) {

                }
            }


            Spacer(modifier = Modifier.height(16.dp)) // Add spacing

            // Photographer's name
//                    Text(
//                        text = photographer ?: "",
//                        style = TextStyle(
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 18.sp, // Customize font size
//                        )
//                    )

            Spacer(modifier = Modifier.height(16.dp)) // Add spacing

            // Share and Download buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Share button
                Button(
                    onClick = {


                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .height(48.dp), // Customize button height
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF)), // Customize button color
                ) {
                    Icon(
                        imageVector = Icons.Default.Share, contentDescription = null,
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Add spacing
                    Text(
                        text = "Share",
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.width(16.dp)) // Add spacing

                // Download button
                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(horizontal = 10.dp), // Customize button height
                    colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF34C759)), // Customize button color
                ) {

                    Spacer(modifier = Modifier.width(8.dp)) // Add spacing
                    Text(
                        text = "Download"
                    )
                }
            }
        }
    }
}

