allure.api.addTranslation('en', {
    tab: {
        support: {
            name: 'Support'
        }
    },
});
allure.api.addTranslation('ru', {
    tab: {
        support: {
            name: 'Поддержка'
        }
    },
});
allure.api.addTab('support', {
    title: 'tab.support.name', icon: 'fa fa-users',
    route: 'support(/)(:testGroup)(/)(:testResult)(/)(:testResultTab)(/)',
    onEnter: (function (testGroup, testResult, testResultTab) {
        return new allure.components.TreeLayout({
            testGroup: testGroup,
            testResult: testResult,
            testResultTab: testResultTab,
            tabName: 'tab.support.name',
            baseUrl: 'support',
            url: 'data/support.json'
        });
    })
});



allure.api.addTranslation('en', {
    tab: {
        printform: {
            name: 'Print Forms'
        }
    },
});
allure.api.addTranslation('ru', {
    tab: {
        printform: {
            name: 'Печатные формы'
        }
    },
});
allure.api.addTab('printform', {
    title: 'tab.printform.name', icon: 'fa fa-users',
    route: 'printform(/)(:testGroup)(/)(:testResult)(/)(:testResultTab)(/)',
    onEnter: (function (testGroup, testResult, testResultTab) {
        return new allure.components.TreeLayout({
            testGroup: testGroup,
            testResult: testResult,
            testResultTab: testResultTab,
            tabName: 'tab.printform.name',
            baseUrl: 'printform',
            url: 'data/printform.json'
        });
    })
});



allure.api.addTranslation('en', {
    tab: {
        tskresp: {
            name: 'Tsk Resp'
        }
    },
});
allure.api.addTranslation('ru', {
    tab: {
        tskresp: {
            name: 'Поддержка ТСК'
        }
    },
});
allure.api.addTab('tskresp', {
    title: 'tab.tskresp.name', icon: 'fa fa-star',
    route: 'tskresp(/)(:testGroup)(/)(:testResult)(/)(:testResultTab)(/)',
    onEnter: (function (testGroup, testResult, testResultTab) {
        return new allure.components.TreeLayout({
            testGroup: testGroup,
            testResult: testResult,
            testResultTab: testResultTab,
            tabName: 'tab.tskresp.name',
            baseUrl: 'tskresp',
            url: 'data/tskresp.json'
        });
    })
});