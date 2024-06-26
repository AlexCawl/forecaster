package org.alexcawl.forecaster.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import org.alexcawl.forecaster.common.Consumer

abstract class BaseFragment<S, A> : Consumer<S>, Fragment {
    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    protected abstract val store: BaseStore<S, A>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        store.observe(lifecycleOwner = viewLifecycleOwner, stateConsumer = this)
    }
}