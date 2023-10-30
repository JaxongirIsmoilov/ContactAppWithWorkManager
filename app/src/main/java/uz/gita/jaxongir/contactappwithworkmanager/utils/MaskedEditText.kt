package uz.gita.jaxongir.contactappwithworkmanager.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.math.absoluteValue

const val mask = "90 123 45 67"

object PhoneMaskTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed =
            if (text.text.length >= 9) text.text.substring(0..8) else text.text

        val annotatedString = AnnotatedString.Builder().run {
            for (i in trimmed.indices) {
                append(trimmed[i])
                if (i == 1 || i == 4 || i == 6) {
                    append(" ")
                }
            }
            pushStyle(SpanStyle(color = Color.LightGray))
            append(mask.takeLast(mask.length - length))
            toAnnotatedString()
        }
        val phoneNumberOffsetTranslator: OffsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= 1) return offset
                if (offset <= 4) return offset + 1
                if (offset <= 6) return offset + 2
                if (offset <= 9) return offset + 3
                return 12
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 1) return offset
                if (offset <= 4) return offset - 1
                if (offset <= 6) return offset - 2
                if (offset <= 9) return offset - 3
                return 9
            }
        }

        return TransformedText(annotatedString, phoneNumberOffsetTranslator)
    }
}

class MaskDateTransformation() : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return maskFilter(text)
    }
}


fun maskFilter(text: AnnotatedString): TransformedText {

    // NNNNN-NNN ##/##/####
    val trimmed = if (text.text.length >= 8) text.text.substring(0..7) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i==2||i==4) out += "/"
    }

    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 4) return offset
            if (offset <= 8) return offset +1
            return 9
        }
        override fun transformedToOriginal(offset: Int): Int {
            if (offset <=5) return offset
            if (offset <=9) return offset -1
            return 8
        }
    }

    return TransformedText(AnnotatedString(out), numberOffsetTranslator)
}
class MaskVisualTransformation(private val mask: String) : VisualTransformation {

    private val specialSymbolsIndices = mask.indices.filter { mask[it] != '#' }

    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""
        var maskIndex = 0
        text.forEach { char ->
            while (specialSymbolsIndices.contains(maskIndex)) {
                out += mask[maskIndex]
                maskIndex++
            }
            out += char
            maskIndex++
        }
        return TransformedText(AnnotatedString(out), offsetTranslator())
    }

    private fun offsetTranslator() = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            val offsetValue = offset.absoluteValue
            if (offsetValue == 0) return 0
            var numberOfHashtags = 0
            val masked = mask.takeWhile {
                if (it == '#') numberOfHashtags++
                numberOfHashtags < offsetValue
            }
            return masked.length + 1
        }

        override fun transformedToOriginal(offset: Int): Int {
            return mask.take(offset.absoluteValue).count { it == '#' }
        }
    }
}
