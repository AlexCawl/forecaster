package org.alexcawl.forecaster.ui

import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty

fun <B : ViewBinding> Fragment.viewBinding(
    viewBindingProducer: (View) -> B
): ReadOnlyProperty<Fragment, B> {
    val viewBindingSupplier = { viewBindingProducer(requireView()) }
    return ViewBindingDelegate(lifecycleSupplier(), viewBindingSupplier)
}

private fun Fragment.lifecycleSupplier(): () -> LifecycleOwner = when (this) {
    is DialogFragment -> when (view) {
        null -> {
            { this }
        }
        else -> {
            { viewLifecycleOwner }
        }
    }
    else -> {
        { viewLifecycleOwner }
    }
}
