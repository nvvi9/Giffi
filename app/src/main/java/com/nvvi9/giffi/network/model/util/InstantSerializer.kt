package com.nvvi9.giffi.network.model.util

import kotlinx.datetime.Instant
import kotlinx.datetime.toKotlinInstant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object InstantSerializer : KSerializer<Instant> {

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("Instant", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Instant =
        LocalDateTime.parse(decoder.decodeString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .atZone(ZoneId.systemDefault())
            .toInstant()
            .toKotlinInstant()

    override fun serialize(encoder: Encoder, value: Instant) =
        encoder.encodeString(value.toString())
}