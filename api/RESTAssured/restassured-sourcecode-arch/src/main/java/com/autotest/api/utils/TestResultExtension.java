package com.autotest.api.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class TestResultExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    public static ExtentReports extent = new ExtentReports();
    public static ExtentTest test;

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = data.format(formatter);

        ExtentSparkReporter sparkReport = new ExtentSparkReporter("reports/report_" + formattedDate + ".html");
        extent.attachReporter(sparkReport);
        test = extent.createTest("[" + context.getTestClass().get().getSimpleName().toUpperCase().replace("_", " ") + "]" + " - " + context.getDisplayName())
                .assignCategory(String.valueOf(context.getTags()));
        sparkReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a");
        sparkReport.config().setTimelineEnabled(false);
        sparkReport.config().setTheme(Theme.STANDARD);
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        try {
            if (context.getExecutionException().isEmpty()) {
                test.log(Status.PASS, MarkupHelper.createLabel("Teste do endepoint efetuado com SUCESSO", ExtentColor.GREEN));
            } else {
                test.log(Status.FAIL, context.getExecutionException().toString());
                test.log(Status.FAIL, MarkupHelper.createLabel("Teste do endepoint apresentou FALHA", ExtentColor.RED));
            }
        } catch (Exception ignored) {
        } finally {
            extent.flush();
        }
    }

    public void registroRespostaBodyRelatorio(ExtractableResponse<Response> response) {
        test.createNode("Responsta do serviço:  ").info(MarkupHelper.createCodeBlock(response.asPrettyString()));
    }
}