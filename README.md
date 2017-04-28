# release-manager
prototype implementation for an extensible application release automation framework

## why

* to implement mvp that helps you perform release management for you artifact

## concepts

### inventory

Inventory hosts details about a commit.
Commit results into production of binary(-ies) which is(-are) promoted up the pipeline.
Therefore it is possible to derive quality of binary by summing attributes about commit(s) that resulted it.
A differential view can be derived by comparing present quality w.r.t same derived at recent historical milestone.

Quality information includes (but are not limited to) 
* detail of change sets 
* number of test cases executed
* coverage report
* static analysis outcome 
* ... any other information that can be contributed by commit quality contributor resource


Primarily
* Version Control System - provides information about the commit (s)
* Continuous Integration Server - provides various information about build(s), test execution detail, coverage etc.
* Binary Repository - provides various information about the binary being produced

### project

Project is the smallest unit
It is identified uniquely using unique parameters like maven GAV
Typically every project has a corresponding CI job to build it ideally on every commit
Projects are versioned

### droplet

Droplet is what gets produced when CI job builds a project
Droplets are hosted in Binary Repository or uniquly identifiable location (UIL)
Droplets participate in potential release

### capability

Capability is a collection of projects
Capability is composable entity
That way, hr-capability can be a composition of performance-management and stuffing capabilities
Capabilities are versioned
One version of Capability maps to one specific version of project(s) and / or capability (-ies)
Capability revisions composes of droplets for all associated projects (of self and enclosing capability)

### product

Product is a collection of capabilities
Being part of product, capabilities can assert dependencies over one or more capabilities
At a given moment in time, a Release Candidate (RC) of the product is being subjected to promotion

### portfolio

Portfolio is a collection of products

### deployment pipeline

Deployment Pipeline promotes revisions RUs from one environment to the other
A pipeline performs pre and post promotion activity and produces metadata that works as qualifiers for the Release Unit Revision (RUR)

### target environment

Target environment is a destination where droplets are deployed if yet unavailable
Droplets can express configuration requirement, by using environment specific namaspace example, [dev].propertyA.value etc.




