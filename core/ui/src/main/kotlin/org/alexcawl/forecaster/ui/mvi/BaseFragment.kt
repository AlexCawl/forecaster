package org.alexcawl.forecaster.ui.mvi

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import org.alexcawl.forecaster.common.Consumer

abstract class BaseFragment<S, A> : Consumer<S>, Fragment {
    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    protected abstract val store: BaseStore<S, A>
    protected abstract val binding: ViewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        store.observe(lifecycleOwner = viewLifecycleOwner, stateConsumer = this)
    }
}
