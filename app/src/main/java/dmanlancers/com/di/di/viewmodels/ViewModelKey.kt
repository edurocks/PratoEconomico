package dmanlancers.com.di.di.viewmodels

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)