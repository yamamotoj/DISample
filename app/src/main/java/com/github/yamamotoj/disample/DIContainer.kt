package com.github.yamamotoj.disample

class DIContainer {
    private class Item<T : Any>(val resolver: (DIContainer) -> T) {
        private var instance: T? = null
        fun resove(container: DIContainer) =
                instance ?: resolver(container).apply { instance = this }
    }

    private val items = mutableMapOf<String, Item<out Any>>()
    private fun <T> createKey(cls: Class<T>, name: String?): String = cls.name + name

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> resolve(cls: Class<T>, name: String? = null): T =
            synchronized(items) { (items[createKey(cls, name)] as Item<T>) }.resove(this)

    fun <T : Any> register(cls: Class<T>, name: String? = null, resolver: (DIContainer) -> T) =
            synchronized(items) { items.put(createKey(cls, name), Item(resolver)); Unit }
}