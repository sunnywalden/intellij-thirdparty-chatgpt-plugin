// src/main/kotlin/com/sunnywalden/chatgpt/ui/ApiKeyDialog.kt
package com.sunnywalden.chatgpt.ui

import com.intellij.openapi.ui.DialogWrapper
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTextField

class ApiKeyDialog : DialogWrapper(true) {
    private val apiKeyField = JTextField()

    init {
        init()
        title = "Enter OpenAI API Key"
    }

    override fun createCenterPanel(): JComponent {
        val panel = JPanel()
        panel.add(apiKeyField)
        return panel
    }

    fun getApiKey(): String {
        return apiKeyField.text
    }
}