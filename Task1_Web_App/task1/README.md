Assumption:

The SQL DB has more than 1M+ rows, I didn't have so much data but as far as I have researched the approach of streaming the data does the job for this use-case.

I also assumed we need the output as JSON over HTTP and not as a downloadable file (in this case I would have used Spring Batch which is more suited for offline based use-case)
I also could have used spring-flux for streaming data over HTTP, both (this and my current) approach work the same.