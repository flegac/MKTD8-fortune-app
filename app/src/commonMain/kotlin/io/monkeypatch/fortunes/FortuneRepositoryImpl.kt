package io.monkeypatch.fortunes

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.serialization.StructureKind
import kotlin.reflect.KClass


class FortuneRepositoryImpl(
    private val fortunesUrl: String
) : FortuneRepository {
    private val client
        get() = HttpClient {
            //TODO("Install JsonFeature with KotlinxSerializer, add a mapper for Fortune objects")
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }

    override suspend fun getRandomFortune(): Fortune = client.get(fortunesUrl)
}