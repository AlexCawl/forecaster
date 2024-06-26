package org.alexcawl.forecaster.ui

class StoreContext<S>(val reduce: suspend ((S) -> S) -> Unit)
