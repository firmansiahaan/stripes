# Stripes
Stripes ...and Java Web Development is fun again

**Stripes is a lightweight Java web framework designed to simplify Servlet/JSP development, emphasizing convention over configuration, minimal dependencies, and fast iterative coding. The latest stable release is Stripes 1.6.0-Jakarta (December 2023), updated for Jakarta EE compatibility and modern Java versions.**  

---

## 🌐 Overview of Stripes Framework
- **Purpose**: Makes Java Servlet/JSP web development easier, intuitive, and straightforward.
- **Philosophy**:
  - *Convention over Configuration (CoC)* → reduces boilerplate.
  - *Lightweight* → very few external dependencies.
  - *Iterative workflow* → quick code/deploy/test cycles.
  - *Application stack agnostic* → integrates easily with existing stacks.
- **Use Cases**: Web applications of all types, especially where simplicity and speed matter.

---

## 🔑 Key Features
- **ActionBeans**: Central controller classes that handle requests and responses.
- **Binding & Validation**: Automatic binding of request parameters to Java objects, with built-in validation.
- **JSP Integration**: Works seamlessly with JSPs and custom tag libraries.
- **Minimal XML Configuration**: Relies on annotations instead of heavy XML setups.
- **Extensions**: Plugins available for dependency injection, XSS sanitization, and more.

---

## 📦 Latest Release (1.6.0-Jakarta, Dec 2023)
- **Java Compatibility**: Built with Java 11, backward compatible with JDK 8+.
- **Jakarta EE Upgrade**: Uses Servlet 6.0 and latest Jakarta APIs.
- **Testing**: Migrated from TestNG to JUnit4; all tests pass.
- **Security Updates**:
  - Removed Log4J logger (due to Log4Shell vulnerability).
  - Default logger now `SimpleJdk14Logger`.
- **Dependency Updates**:
  - Spring updated to 5.3.29 (not yet Spring 6).
  - Commons-fileupload moved to `commons-fileupload2`.
- **Examples**: Bugzooky sample app and Canoo webtests now fully functional with Tomcat 10.  [Github](https://github.com/StripesFramework/stripes/releases)

---


## 🚨 Risks & Limitations
- **Community Size**: Smaller compared to Spring, meaning fewer tutorials and third-party integrations.
- **Maintenance**: Development slowed in past years; recent Jakarta update revived activity, but long-term support is uncertain.
- **Enterprise Adoption**: Less common in large-scale corporate environments compared to Spring MVC or JSF.  

---
