package org.alexcawl.forecaster.ui.mvi

class StoreContext<S>(val reduce: suspend ((S) -> S) -> Unit)
