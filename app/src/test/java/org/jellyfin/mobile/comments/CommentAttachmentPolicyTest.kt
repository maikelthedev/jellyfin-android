package org.jellyfin.mobile.comments

import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CommentAttachmentPolicyTest {

    @Test
    fun `accepts GIF, WebP, PNG and JPEG`() {
        CommentAttachmentPolicy.extensionFor("image/gif") shouldBe "gif"
        CommentAttachmentPolicy.extensionFor("image/webp") shouldBe "webp"
        CommentAttachmentPolicy.extensionFor("image/png") shouldBe "png"
        CommentAttachmentPolicy.extensionFor("image/jpeg") shouldBe "jpg"
    }

    @Test
    fun `normalises case and ignores MIME parameters`() {
        CommentAttachmentPolicy.extensionFor("IMAGE/GIF") shouldBe "gif"
        CommentAttachmentPolicy.extensionFor("image/jpeg; charset=binary") shouldBe "jpg"
        CommentAttachmentPolicy.extensionFor(" image/png ") shouldBe "png"
    }

    @Test
    fun `rejects unsupported and missing MIME types`() {
        CommentAttachmentPolicy.extensionFor(null) shouldBe null
        CommentAttachmentPolicy.extensionFor("") shouldBe null
        CommentAttachmentPolicy.extensionFor("image/svg+xml") shouldBe null
        CommentAttachmentPolicy.extensionFor("video/mp4") shouldBe null
    }

    @Test
    fun `advertises the same MIME types to the picker and keyboard`() {
        CommentAttachmentPolicy.mimeTypes.toList() shouldContainExactlyInAnyOrder
            listOf("image/gif", "image/webp", "image/png", "image/jpeg")
    }
}
