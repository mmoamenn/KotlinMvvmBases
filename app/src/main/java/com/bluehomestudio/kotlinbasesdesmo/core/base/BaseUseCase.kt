package com.bluehomestudio.kotlinbasesdesmo.core.base

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class BaseUseCase() {

    private val disposableList = CompositeDisposable()

    //todo : inject Schedulers to user Schedulers.trampoline() in unite testing

    private fun <T> loadNetwork(observable: Observable<T>) =
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun loadNetwork(observable: Completable) =
        observable.subscribeOn(Schedulers.trampoline())
            .observeOn(AndroidSchedulers.mainThread())

    fun <T> loadNetwork(observable: Observable<T>, success: (T) -> Unit, error: (Throwable)-> Unit) =
        disposableList.add(loadNetwork(observable).subscribe(success, error))

    fun loadNetwork(completable: Completable, success: () -> Unit, error: (Throwable) -> Unit) {
        disposableList.add(loadNetwork(completable).subscribe(success, error))
    }

    fun addDisposable(disposableItem: Disposable){
        disposableList.add(disposableItem)
    }

    fun deleteDisposable(disposableItem: Disposable){
        disposableList.remove(disposableItem)
    }

    fun unsubscribe(){
        disposableList.clear()
    }


}