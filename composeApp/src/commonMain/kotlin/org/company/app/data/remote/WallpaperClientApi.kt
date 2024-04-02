package org.company.app.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.company.app.domain.model.Wallpaper
import org.company.app.util.Constant.API_KEY
import org.company.app.util.Constant.AUTHORIZATION

object WallpaperClientApi {

    @OptIn(ExperimentalSerializationApi::class)
    private val client = HttpClient {

        install(ContentNegotiation) {

            json(Json {
                isLenient = false
                ignoreUnknownKeys = true
                encodeDefaults = false
                explicitNulls = false
            })

        }

        install(HttpTimeout) {
            val timeout = 300000L
            connectTimeoutMillis = timeout
            socketTimeoutMillis = timeout
            requestTimeoutMillis = timeout
        }

        defaultRequest {
            headers {
                append(AUTHORIZATION, API_KEY)
            }
        }
    }

    suspend fun getWallpapers(per_page: Int, page: Int): Wallpaper {
        val url = "https://api.pexels.com/v1/curated?per_page=$per_page&page=$page"
        return client.get(url).body()
    }
}