package org.company.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter
import org.company.app.data.model.Photo


@Composable
fun WallpaperList(
    photo: List<Photo>,
    state: LazyGridState,
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(120.dp),
        state = state,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(photo) { photo ->
            WallpaperItem(photo = photo)
        }

    }

}


@Composable
fun WallpaperItem(photo: Photo) {
    var liked by rememberSaveable {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp) // Increased padding for spacing
    ) {
        // Apply a gradient background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFFE1E1E1), Color(0xFFBDBDBD))
                    )
                )
        )

        val image = rememberImagePainter(photo.src.large2x)
        Image(
            painter = image, contentDescription = "null",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(4.dp))
                .shadow(4.dp, RoundedCornerShape(4.dp)),
        )

        Spacer(modifier = Modifier.height(8.dp)) // Increased spacing

        Card(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(2.dp))
                .padding(4.dp) // Increased padding
                .shadow(2.dp, RoundedCornerShape(2.dp)) // Add shadow
        ) {
            Text(
                text = photo.photographer,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp, // Adjust font size
                    fontFamily = FontFamily.Serif, // Use a custom font family
                    color = Color.Black // Customize text color
                ),
                modifier = Modifier.padding(8.dp), // Increased padding
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                textAlign = TextAlign.Start
            )
        }
        IconButton(modifier = Modifier
            .align(Alignment.BottomEnd)
            .toggleable(
                value = true,
                indication = null,
                interactionSource = MutableInteractionSource(),
                onValueChange = {}
            ),
            onClick = {
                liked = !liked
            }
        ) {
            Icon(
                imageVector = if (liked) Icons.Sharp.Favorite else Icons.Sharp.FavoriteBorder,
                contentDescription = "",
                tint = if (liked) Color.Red else Color.White
            )
        }
    }
}


