package app.bo.com.ucb.clean22021

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel

abstract class ScopedViewMode: ViewModel(), Scope by Scope.Impl() {
    init {
        initScope()
    }
    @CallSuper
    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}

