package org.alexcawl.forecaster

import android.content.Context
import android.opengl.GLES32.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

fun Context.compileShader(type: Int, fileName: String): Int {
    val shader = glCreateShader(type)
    glShaderSource(shader, this.readFromAssets(fileName))
    glCompileShader(shader)

    val compileStatus = IntArray(1)
    glGetShaderiv(shader, GL_COMPILE_STATUS, compileStatus, 0)
    if (compileStatus[0] == 0) {
        glDeleteShader(shader)
        throw RuntimeException("Error compiling shader: " + glGetShaderInfoLog(shader))
    }

    return shader
}

private fun Context.readFromAssets(fileName: String): String {
    try {
        val inputStream = assets.open(fileName)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()

        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line).append("\n")
        }

        bufferedReader.close()
        inputStream.close()

        return stringBuilder.toString()
    } catch (e: IOException) {
        throw RuntimeException(e)
    }
}