INTEGRITY:

We use integrity constraints to ensure that invalid data is never inserted into tables, thus keeping the data consistent throughout.
Additionally, we can use triggers where it makes sense to help maintain data consistency. 
However, triggers can become expensive if not used carefully—for example, executing heavy computations after every row insertion could easily lead to slow I/O operations.

Other use case:
We can use triggers to automatically create a new product table as soon as a new category is added to the main category table, and later alter the table to add necessary columns.

SCALABILITY:

To achieve high scalability, we can perform two major tasks:

1) Data Sharding
2) Data Replication

For sharding, we divide the data using consistent hashing and further replicate these shards across multiple servers.
Of course, there's a trade-off between cost and performance, which needs to be evaluated using appropriate metrics.

EFFICIENT QUERY PERFORMANCE:

We can use materialized views where appropriate, since they do require additional storage.

Use case:
Performing a join operation on every product read request would be too expensive when dealing with millions of product rows. Materialized views help by precomputing and storing the results of joins ahead of time.
Since e-commerce platforms like Amazon are typically read-heavy (logical assumption), materialized views can significantly improve performance. However, they come with the trade-off of higher storage consumption.
Ultimately, it boils down to choosing between greater user experience with faster reads vs the cost of increased storage usage.