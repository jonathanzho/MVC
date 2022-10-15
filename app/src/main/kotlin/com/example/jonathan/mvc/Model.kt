package com.example.jonathan.mvc

import java.util.*
import kotlin.collections.ArrayList

class Model : Observable {
    private var mSize: Int = 0
    private var mCountList: MutableList<Int>

    constructor(size: Int) {
        mSize = size
        mCountList = ArrayList(mSize)

        var i = 0
        while (i < mSize) {
            mCountList.add(0)
            i++
        }
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getValueAtIndex(index: Int): Int {
        return mCountList[index]
    }

    @Throws(IndexOutOfBoundsException::class)
    fun incrementValueAtIndex(index: Int) {
        mCountList[index] = mCountList[index] + 1
        setChanged()
        notifyObservers()
    }
}
