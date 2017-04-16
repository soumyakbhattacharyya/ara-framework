# ara-framework
prototype implementation for an extensible application release automation framework

## why

* We believe "deployment pipeline as code" is the new future for release management.
* However traditionally release management software have shined brilliantly for a specific technology / functional domain.
* Best of the both world can be attained if we arrive at an extensible application release automation framework which helps in authoring domain specific language easily.
* This is an attempt for attaining the nirvana.

## concepts

### configuration

Configuration is anything that yeilds information about one commit or a range of commits.

Primarily
* Version Control System - provides information about the commit (s)
* Continuous Integration Server - provides various information about build(s)
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




