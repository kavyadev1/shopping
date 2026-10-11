# Bug Journal

## Bug 1: Spring ignored all settings in application.properties

**Situation:**
**Problem:**
**Action:**
**Result:**

A stronger version of your line:

Today I learned that ddl-auto=update never changes an existing column’s type, which causes schema drift between my Java code and the database. On my laptop I fixed it by dropping the empty table, but in production you’d use ALTER TABLE through a Flyway migration.