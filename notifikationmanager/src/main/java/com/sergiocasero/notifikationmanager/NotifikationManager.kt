package com.sergiocasero.notifikationmanager

import java.util.*

/**
 * NotifikationManager.
 */
object NotifikationManager : Observable() {

    private val NO_OBSERVERS = 0

    fun notify(any: Any) {
        synchronized(this) {
            setChanged()
            notifyObservers(any)
        }
    }

    fun isAppInForeground() = countObservers() != NO_OBSERVERS
}