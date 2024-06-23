package org.alexcawl.forecaster

import android.content.Context
import android.opengl.GLES32.*


object ShaderUtils {
    fun createProgram(shaderId: Int): Int {
        val programId = glCreateProgram()
        if (programId == 0) {
            return 0
        }

        glAttachShader(programId, shaderId)
        glLinkProgram(programId)
        val linkStatus = IntArray(1)
        glGetProgramiv(programId, GL_LINK_STATUS, linkStatus, 0)
        if (linkStatus[0] == 0) {
            glDeleteProgram(programId)
            return 0
        }
        return programId
    }

    fun createShader(context: Context, type: Int, shaderRawId: Int): Int {
        val shaderText: String = FileUtils
            .readTextFromRaw(context, shaderRawId)
        return createShader(type, shaderText)
    }

    fun createShader(type: Int, shaderText: String?): Int {
        val shaderId = glCreateShader(type)
        if (shaderId == 0) {
            return 0
        }
        glShaderSource(shaderId, shaderText)
        glCompileShader(shaderId)
        val compileStatus = IntArray(1)
        glGetShaderiv(shaderId, GL_COMPILE_STATUS, compileStatus, 0)
        if (compileStatus[0] == 0) {
            glDeleteShader(shaderId)
            return 0
        }
        return shaderId
    }
}