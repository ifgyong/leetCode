//
//     Generated by class-dump 3.5 (64 bit).
//
//     class-dump is Copyright (C) 1997-1998, 2000-2001, 2004-2013 by Steve Nygard.
//

#import "NSObject.h"

@interface NSObject (FYLogCenter)
+ (void)fyaspect_hookClass:(Class)arg1 WithSelector:(SEL)arg2 withOptions:(unsigned long long)arg3 usingBlock:(id)arg4 error:(id *)arg5;
+ (void)load;
- (id)getViewControllerSubClass:(Class)arg1;
- (_Bool)isCanHookClass:(Class)arg1;
- (void)getAllClassInfoWithClass;
- (void)run;
- (void)fyaspect_hookClass:(Class)arg1 WithSelector:(SEL)arg2 withOptions:(unsigned long long)arg3 usingBlock:(id)arg4 error:(id *)arg5;
- (id)hookClassInfo;
@end

