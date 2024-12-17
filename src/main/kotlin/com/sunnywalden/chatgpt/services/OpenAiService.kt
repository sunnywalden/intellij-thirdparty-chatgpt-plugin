package com.sunnywalden.chatgpt.services

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class OpenAiService(private val apiKey: String) {
    private val client = OkHttpClient()
    private val gson = Gson()

    fun makeRequest(model: String, prompt: String): String {
        val url = "https://api.openai.com/v1/engines/$model/completions"
        val json = gson.toJson(mapOf("prompt" to prompt, "max_tokens" to 100))
        val body = json.toRequestBody("application/json".toMediaTypeOrNull())
        val request = Request.Builder()
            .url(url)
            .post(body)
            .addHeader("Authorization", "Bearer $apiKey")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            return response.body?.string() ?: ""
        }
    }
}