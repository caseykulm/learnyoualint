package com.caseykulm.checks

import com.android.SdkConstants
import com.android.tools.lint.detector.api.*
import com.caseykulm.checks.ExplicitStyleError.TacoBellPrimaryButton
import org.w3c.dom.Attr
import org.w3c.dom.Document
import org.w3c.dom.Element

private enum class ExplicitStyleError(val styleStr: String, val errorMessage: String) {
    TacoBellPrimaryButton(
        styleStr = "@style/TacoBellButton",
        errorMessage = "Use ?attr/style_buttonPrimary instead"
    )
}

class ExplicitStyleCheck : LayoutDetector() {
    companion object {
        private val IMPLEMENTATION = Implementation(ExplicitStyleCheck::class.java, Scope.RESOURCE_FILE_SCOPE)

        val ISSUE = Issue.create(
            id = "ExplicitStyleCheck",
            briefDescription = "Semantic Naming Error",
            explanation = "Checks for violations of not using an existing semantic name",
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.ERROR,
            implementation = IMPLEMENTATION
        )
    }

    init {
        println("TIGER start")
    }

    override fun getApplicableElements() = XmlScannerConstants.ALL.also { println("TIGER getApplicableElements") }

    override fun visitAttribute(context: XmlContext, attribute: Attr) {
        println("TIGER visitAttribute")
    }

    override fun visitDocument(context: XmlContext, document: Document) {
        println("TIGER visitDocument")
    }

    override fun visitElement(context: XmlContext, element: Element) {
        println("TIGER visitElement")

        if (element.nodeName == SdkConstants.ATTR_STYLE && element.nodeValue == TacoBellPrimaryButton.styleStr) {
            context.report(ISSUE, context.getLocation(element), TacoBellPrimaryButton.errorMessage)
        }
    }
}