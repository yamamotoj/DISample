package com.github.yamamotoj.disample

import android.app.Application


class DISampleApplication : Application() {
    val container by lazy {

        // dependency definition
        DIContainer().apply {
            register(A::class.java) { A() }
            register(B::class.java) { B(resolve(A::class.java)) }
            register(C::class.java) { C() }
            register(D::class.java) { D(resolve(B::class.java), resolve(C::class.java)) }
        }
    }
}
