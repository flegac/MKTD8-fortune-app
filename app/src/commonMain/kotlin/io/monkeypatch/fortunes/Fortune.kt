package io.monkeypatch.fortunes
import kotlinx.serialization.Serializable

//TODO implement the Fortune model, to conform to FortuneTest

@Serializable
data class Fortune(val id: Int, val quote: String)