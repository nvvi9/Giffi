package com.nvvi9.giffi.ui.core

import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.nvvi9.giffi.ui.theme.GiffiTheme
import com.nvvi9.giffi.vo.UserGifResource
import kotlinx.datetime.Instant
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GifResourceCardExpanded(
    userGifResource: UserGifResource,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = modifier
    ) {
        Column {
            SubcomposeAsyncImage(
                model = userGifResource.gifUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                loading = { CircularProgressIndicator() },
                imageLoader = ImageLoader.Builder(LocalContext.current)
                    .components {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                            add(ImageDecoderDecoder.Factory())
                        } else {
                            add(GifDecoder.Factory())
                        }
                    }.build(),
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = userGifResource.title,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = dateFormatted(userGifResource.publishDate),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Preview("GifResourceCardExpanded")
@Composable
private fun ExpandedGifResourcePreview(
    @PreviewParameter(UserGifResourcePreviewParameterProvider::class)
    userGifResources: List<UserGifResource>
) {
    CompositionLocalProvider(LocalInspectionMode provides true) {
        GiffiTheme {
            Surface {
                GifResourceCardExpanded(
                    userGifResource = userGifResources[0],
                    onClick = {}
                )
            }
        }
    }
}

private fun dateFormatted(date: Instant) =
    SimpleDateFormat("MMM d, yyyy", Locale.getDefault()).format(Date(date.toEpochMilliseconds()))
