package org.alexcawl.forecaster

import android.content.Context
import android.opengl.GLES32.*
import android.opengl.GLSurfaceView
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10


class MyGLSurfaceView(context: Context) : GLSurfaceView(context) {
    private val renderer: MyGLRenderer = MyGLRenderer(context)

    init {
        setEGLContextClientVersion(3)
        setRenderer(renderer)
    }
}

class MyGLRenderer(
    private val context: Context
) : GLSurfaceView.Renderer {
    private var program = 0
    private var vertexShader = 0
    private var fragmentShader = 0

    override fun onSurfaceCreated(unused: GL10, config: EGLConfig) {
        glClearColor(1f, 1f, 1f, 0.5f)
        vertexShader = context.compileShader(GL_VERTEX_SHADER, "vertex.glsl")
        fragmentShader = context.compileShader(GL_FRAGMENT_SHADER, "fragment.glsl")
        program = glCreateProgram()
        glAttachShader(program, vertexShader)
        glAttachShader(program, fragmentShader)
        glLinkProgram(program)
        glUseProgram(program)
    }

    private val position = floatArrayOf(
        0f, 0f
    )

    override fun onDrawFrame(gl: GL10) {
        glClear(GL_COLOR_BUFFER_BIT)
        glVertexAttrib2fv(0, position, 0)
        glDrawArrays(GL_POINTS, 0, 3)
    }

    override fun onSurfaceChanged(unused: GL10, width: Int, height: Int) {
        glViewport(0, 0, width, height)
    }
}
