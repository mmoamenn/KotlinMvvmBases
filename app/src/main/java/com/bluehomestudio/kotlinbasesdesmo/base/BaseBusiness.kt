package com.bluehomestudio.kotlinbasesdesmo.base

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class BaseBusiness(){

    private val disposableList = CompositeDisposable()

    private fun <T> loadNetwork(observable: Observable<T>) =
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun loadNetwork(observable: Completable) =
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

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