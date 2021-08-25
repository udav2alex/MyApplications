package ru.gressor.myapplications.utils.di

import kotlin.reflect.KClass

object ServiceLocator {

    private val container = mutableMapOf<KClass<*>, Any>()

    inline fun <reified T: Any> register(obj: T) = register(T::class, obj)

    fun <T : Any> register(kClass: KClass<T>, obj: T) { container[kClass] = obj }

    @Suppress("UNCHECKED_CAST")
    fun <T: Any> get(kClass: KClass<T>) = container[kClass] as T
}

inline fun <reified T: Any> locateLazily(): Lazy<T> = lazy { ServiceLocator.get(T::class) }