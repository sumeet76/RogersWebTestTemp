# RogersWebTestAutomation
Test Automation for Rogers.com
[Under Construction]
How to Launch Tests

To run tests on SauceLabs
gradle sauceTest   -Ptest_browser=saucechrome -Ptest_language=en   --tests 'RogersCH_Regression*' -Ptest_threadCount=1 -Ptest_qaURL=https://qa6.Rogers.com -i --stacktrace

To run tests on Local
gradle localTest   -Ptest_browser=chrome -Ptest_language=en   --tests 'RogersCH_Regression*' -Ptest_threadCount=1 -Ptest_qaURL=https://qa6.Rogers.com -i --stacktrace
