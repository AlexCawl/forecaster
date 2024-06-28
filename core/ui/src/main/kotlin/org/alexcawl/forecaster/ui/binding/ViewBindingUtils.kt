package org.alexcawl.forecaster.ui.binding

import android.view.View
import androidx.appcompat.app.AppCompatActivity
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

fun <B : ViewBinding> AppCompatActivity.viewBinding(
    viewBindingProducer: (View) -> B
): ReadOnlyProperty<AppCompatActivity, B> {
    val viewBindingSupplier = { viewBindingProducer(window.decorView.rootView) }
    return ViewBindingDelegate(lifecycleSupplier(), viewBindingSupplier)
}

private fun AppCompatActivity.lifecycleSupplier(): () -> LifecycleOwner = { this }