package org.jellyfin.mobile.comments

import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.jellyfin.mobile.R
import org.jellyfin.mobile.databinding.FragmentPlayerBinding
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

/**
 * The paperclip is the only attachment entry point that also accepts still images. It must stay in
 * the composer beside Post.
 */
@RunWith(AndroidJUnit4::class)
class CommentsAttachLayoutTest {

    @Test
    fun attachButtonIsVisibleAndEnabled() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val context = ContextThemeWrapper(instrumentation.targetContext, R.style.AppTheme)

        lateinit var binding: FragmentPlayerBinding
        instrumentation.runOnMainSync {
            binding = FragmentPlayerBinding.inflate(LayoutInflater.from(context))
        }

        assertEquals(View.VISIBLE, binding.commentsAttach.visibility)
        assertTrue(binding.commentsAttach.isEnabled)
        assertEquals(context.getString(R.string.comments_attach), binding.commentsAttach.contentDescription)
    }
}
