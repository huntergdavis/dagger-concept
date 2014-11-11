Purpose of this project
===
This project was created to demo ways to use dagger. Basically:
- Do not use @Inject on constructors
- When compiler complain about no injectable and asking do you want to add inject constructor, don't do that. Use includes in @Module annotation instead
- We could use customized @Qualifier to identify different items to inject.