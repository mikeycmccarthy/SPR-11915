SPR-11915
=========

This is a simple test project for investigation into the Sring JIRA issue SPR-11915.

As some background, I have been using the Spring Dropwizard integration at https://github.com/nhuray/dropwizard-spring on a project at work and have found that manually registering PlatformTransactionManagers in a ConfigurableApplicationContext means they are not resolved when @TransactionManager is used with a specific qualifier.
