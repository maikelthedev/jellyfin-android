package org.jellyfin.mobile.comments

/**
 * The image types a comment may attach, shared by the keyboard GIF tab and the file picker.
 */
object CommentAttachmentPolicy {
    private val extensions = linkedMapOf(
        "image/gif" to "gif",
        "image/webp" to "webp",
        "image/png" to "png",
        "image/jpeg" to "jpg",
    )

    val mimeTypes: Array<String> = extensions.keys.toTypedArray()

    fun extensionFor(contentType: String?): String? {
        val normalized = contentType
            ?.substringBefore(';')
            ?.trim()
            ?.lowercase()
            ?: return null
        return extensions[normalized]
    }
}
