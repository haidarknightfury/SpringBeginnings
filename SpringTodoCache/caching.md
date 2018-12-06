- Spring’s caching abstraction is largely built around aspects. When you enable caching in Spring, an aspect is created that triggers off one or more
of Spring’s caching annotations.

- @Cacheable Indicates that Spring should look in a cache for the method’s return value 
before invoking the method. If the value is found, the cached value is returned. 
If not, then the method is invoked and the return value is put in the cache.

- @CachePut Indicates that Spring should put the method’s return value in a cache. The 
cache isn’t checked prior to method invocation, and the method is always 
invoked. 

@CacheEvict Indicates that Spring should evict one or more entries from a cache. 

@Caching A grouping annotation for applying multiples of the other caching annotations 
at once.  


