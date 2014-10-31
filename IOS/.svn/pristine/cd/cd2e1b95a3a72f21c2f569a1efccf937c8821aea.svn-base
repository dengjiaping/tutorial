//
//  TMConcise.h
//  TBWantu
//
//  Created by huangxiaowei on 12-9-14.
//  Copyright (c) 2012年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface TMPagedArray : NSObject {
    int _currentPage;
    int _totalPage;
    NSArray *_array;
}
@property (nonatomic, assign) int currentPage;
@property (nonatomic, assign) int totalPage;
@property (nonatomic, retain) NSArray *array;

+ (id)array;
@end


@interface TMCursorArray : NSObject {
    NSString *_cursor;
    BOOL _hasMore;
    NSArray *_array;
}
@property (nonatomic, retain) NSString *cursor;
@property (nonatomic, assign) BOOL hasMore;
@property (nonatomic, retain) NSArray *array;

+ (id)array;
@end

@interface NSDictionary (ForJsonNull)

- (id)objectOrNilForKey:(id)aKey;

- (NSNumber *)numberOrNilForKey:(id)aKey;

- (NSDate *)dateOrNilForKey:(id)aKey;


@end

@interface NSMutableDictionary (SetNilForKey)

- (void)setObjectOrNil:(id)anObject forKey:(id)aKey;

@end




#define $shared(Klass) [Klass sharedInstance]

#define $singleton(Klass)\
\
+ (Klass *)sharedInstance {\
    static Klass *instance = nil;\
    if (instance == nil) {\
        @synchronized(self) {\
            if (instance == nil) {\
                instance = [[self alloc] init];\
            }\
        }\
    }\
	return instance;\
}

