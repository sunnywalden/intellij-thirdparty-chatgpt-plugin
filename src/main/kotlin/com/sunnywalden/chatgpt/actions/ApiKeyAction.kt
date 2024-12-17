// src/main/kotlin/com/sunnywalden/chatgpt/actions/ApiKeyAction.kt
package com.sunnywalden.chatgpt.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.sunnywalden.chatgpt.services.OpenAiService
import com.sunnywalden.chatgpt.ui.ApiKeyDialog

class ApiKeyAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val dialog = ApiKeyDialog()
        if (dialog.showAndGet()) {
            val apiKey = dialog.getApiKey()
            val service = OpenAiService(apiKey)
            // Use the service to make API requests
        }
    }
}