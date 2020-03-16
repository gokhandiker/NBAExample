package com.gkhn.nbaexample.util.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}