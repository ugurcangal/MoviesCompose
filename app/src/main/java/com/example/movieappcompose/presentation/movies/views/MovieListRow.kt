package com.example.movieappcompose.presentation.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.movieappcompose.domain.model.Movie

@Composable
fun MovieListRow(
    movie : Movie,
    onItemClick : (Movie) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(painter = rememberImagePainter(data = movie.Poster),
            contentDescription = movie.Title,
            modifier = Modifier
                .padding(top = 20.dp)
                .size(200.dp, 200.dp)
                .clip(RectangleShape)
        )

        Column(modifier = Modifier.align(CenterVertically).padding(end = 20.dp),horizontalAlignment = Alignment.CenterHorizontally) {
            Text(movie.Title,
                style = MaterialTheme.typography.headlineSmall,
                overflow = TextOverflow.Ellipsis,
                color = White,
                textAlign = TextAlign.Center
            )

            Text(movie.Year,
                style = MaterialTheme.typography.labelLarge,
                overflow = TextOverflow.Ellipsis,
                color = White,
                textAlign = TextAlign.Center
            )

        }


    }
}